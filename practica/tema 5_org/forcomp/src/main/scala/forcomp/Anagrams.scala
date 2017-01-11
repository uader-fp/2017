package forcomp

import common._

object Anagrams {

  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /** `Occurrences` is a `List` of pairs of characters and positive integers saying
   *  how often the character appears.
   *  This list is sorted alphabetically w.r.t. to the character in each pair.
   *  All characters in the occurrence list are lowercase.
   *  
   *  Any list of pairs of lowercase characters and their frequency which is not sorted
   *  is **not** an occurrence list.
   *  
   *  Note: If the frequency of some character is zero, then that character should not be
   *  in the list.
   */
  type Occurrences = List[(Char, Int)]

  /** The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
  val dictionary: List[Word] = loadDictionary
  
  def charDif(w: Word): Word = {
    def charDif(w: Word, acu: Word): Word = {
      if (w.isEmpty()) {
        acu
      } else {
    	  if (!acu.contains(w.head)) {
    		  charDif(w.tail, acu.concat(w.head.toString))  
    	  } else {
    		  charDif(w.tail, acu) 
    	  }        
      }
    }
    charDif(w, "")
  }

  /** Converts the word into its character occurence list.
   *  
   *  Note: the uppercase and lowercase version of the character are treated as the
   *  same character, and are represented as a lowercase character in the occurrence list.
   */
  def wordOccurrences(w: Word): Occurrences = {
    def list = List[(Char, Int)]()                 
    val s2 = charDif(w.toLowerCase().sortWith((a,b) => a<b))                                   

	s2.toList.map((c2) => (c2, w.toLowerCase().count(c3 => c3 == c2)))
  }

  def toString(w: List[Char]): Word = {
    def toString(w: List[Char], acu: Word): Word = 
      if (w.isEmpty) {
          acu
      } else {
    	  w.head.toString.concat(toString(w.tail, acu))        
      }
    
    toString(w, "")
  }
  
  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(toString(s.flatten))

  /** The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all
   *  the words that have that occurrence count.
   *  This map serves as an easy way to obtain all the anagrams of a word given its occurrence list.
   *  
   *  For example, the word "eat" has the following character occurrence list:
   *
   *     `List(('a', 1), ('e', 1), ('t', 1))`
   *
   *  Incidentally, so do the words "ate" and "tea".
   *
   *  This means that the `dictionaryByOccurrences` map will contain an entry:
   *
   *    List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
   *
   */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = {
    val grouped = dictionary.map( x => (wordOccurrences(x), x) ).groupBy( x => x._1 )
    grouped.map{ case (occ, occ_and_word) => (occ, occ_and_word.map { case (occ, word) => word }) }
  }

  /** Returns all the anagrams of a given word. */
  def wordAnagrams(word: Word): List[Word] = {
    val o = wordOccurrences(word)
    dictionary.filter((d) =>(wordOccurrences(d).equals(o)))
  }

  /** Returns the list of all subsets of the occurrence list.
   *  This includes the occurrence itself, i.e. `List(('k', 1), ('o', 1))`
   *  is a subset of `List(('k', 1), ('o', 1))`.
   *  It also include the empty subset `List()`.
   * 
   *  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
   *
   *    List(
   *      List(),
   *      List(('a', 1)),
   *      List(('a', 2)),
   *      List(('b', 1)),
   *      List(('a', 1), ('b', 1)),
   *      List(('a', 2), ('b', 1)),
   *      List(('b', 2)),
   *      List(('a', 1), ('b', 2)),
   *      List(('a', 2), ('b', 2))
   *    )
   *
   *  Note that the order of the occurrence list subsets does not matter -- the subsets
   *  in the example above could have been displayed in some other order.
   */
  def combinations(occurrences: Occurrences): List[Occurrences] = {
    def getFlatOccurrence(occurrences: Occurrences) : Occurrences = {
      if (occurrences.isEmpty) {
        List()
      } else {
        if (occurrences.head._2 == 1) {
          occurrences.head :: getFlatOccurrence(occurrences.tail)
        } else {
          occurrences.head :: getFlatOccurrence((occurrences.head._1,occurrences.head._2-1) :: occurrences.tail)
        }
      }    
    }
    
    def generate(occurrence: (Char, Int), list:Occurrences): List[Occurrences] ={ 
      if (list.isEmpty) {
        List(List(occurrence))
      } else {
        if (occurrence._1 != list.head._1) {
          List(occurrence, list.head) :: generate(occurrence, list.tail)
        } else {
          generate(occurrence, list.tail)
        }
      }
      
    }
    
    def combinations(occurrences: Occurrences): List[Occurrences] ={
      if (occurrences.isEmpty) {
        List(List())
      } else {
        generate(occurrences.head, occurrences.tail).union(combinations(occurrences.tail))
      }
    }
    
    combinations(getFlatOccurrence(occurrences))
  }
  
  /** Subtracts occurrence list `y` from occurrence list `x`.
   * 
   *  The precondition is that the occurrence list `y` is a subset of
   *  the occurrence list `x` -- any character appearing in `y` must
   *  appear in `x`, and its frequency in `y` must be smaller or equal
   *  than its frequency in `x`.
   *
   *  Note: the resulting value is an occurrence - meaning it is sorted
   *  and has no zero-entries.
   */
  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    x.map((xe) => {
      var xi = xe
      for (ye <- y) {
        if (xe._1 == ye._1) {
           xi = (xe._1, xe._2 - ye._2)
        }
      }
      xi
    }).filter((xe) => xe._2 >= 1)
  }
  /** Returns a list of all anagram sentences of the given sentence.
   *  
   *  An anagram of a sentence is formed by taking the occurrences of all the characters of
   *  all the words in the sentence, and producing all possible combinations of words with those characters,
   *  such that the words have to be from the dictionary.
   *
   *  The number of words in the sentence and its anagrams does not have to correspond.
   *  For example, the sentence `List("I", "love", "you")` is an anagram of the sentence `List("You", "olive")`.
   *
   *  Also, two sentences with the same words but in a different order are considered two different anagrams.
   *  For example, sentences `List("You", "olive")` and `List("olive", "you")` are different anagrams of
   *  `List("I", "love", "you")`.
   *  
   *  Here is a full example of a sentence `List("Yes", "man")` and its anagrams for our dictionary:
   *
   *    List(
   *      List(en, as, my),
   *      List(en, my, as),
   *      List(man, yes),
   *      List(men, say),
   *      List(as, en, my),
   *      List(as, my, en),
   *      List(sane, my),
   *      List(Sean, my),
   *      List(my, en, as),
   *      List(my, as, en),
   *      List(my, sane),
   *      List(my, Sean),
   *      List(say, men),
   *      List(yes, man)
   *    )
   *
   *  The different sentences do not have to be output in the order shown above - any order is fine as long as
   *  all the anagrams are there. Every returned word has to exist in the dictionary.
   *  
   *  Note: in case that the words of the sentence are in the dictionary, then the sentence is the anagram of itself,
   *  so it has to be returned in this list.
   *
   *  Note: There is only one anagram of an empty sentence.
   */
  def sentenceAnagrams(sentence: Sentence): List[Sentence] = {

    def prepend[T](el: T, list: List[List[T]]) : List[List[T]] = list.map{ sublist => el :: sublist }
    def envelope[T](list: List[T]) : List[List[T]] = list.map{ x => List(x) }
    
    def multiply[T](left: List[T], right: List[List[T]]): List[List[T]] = left match {
      case Nil => List()
      case head :: tail => prepend(head, right) ::: multiply(tail, right)
    }

    def product[T](list: List[List[T]]): List[List[T]] = list match {
      case Nil => list
      case head :: tail => if (tail.isEmpty) envelope(head) else multiply(head, product(tail))
    }
    
    def occurrenceAnagrams(occurrences: Occurrences): List[List[Occurrences]] = {
 
      val combs = combinations(occurrences) // only words with occurrences within the combs may participate
  
      val occurrencesInDictionary = dictionaryByOccurrences.keys.toSet
 
      val possible_occs = (combs.toSet & occurrencesInDictionary).toList
 
      val nested_anagrams = possible_occs.map {
        occ =>
          if( occurrences == occ)
            List(List(occ))
          else {
            val remaining = occurrenceAnagrams( subtract(occurrences, occ) )
            if (remaining.isEmpty)
              List()
            else
              prepend(occ, remaining)
          }
      }
 
      if(nested_anagrams.isEmpty)
        List()
      else
        nested_anagrams.reduceLeft( (x,y) => (x:::y) )
    }
 
    // convert sentence to occ
    val occurrences = sentenceOccurrences(sentence)
 
    // call actual anagram finder
    val oa = occurrenceAnagrams(occurrences)
 
    // combine results
    val variants = oa.map{
      occlist => product(occlist.map { occ => dictionaryByOccurrences(occ) } )
    }
 
    // prettify the results
    if(variants.isEmpty) List(List()) else variants.reduceLeft( (x,y) => (x:::y) )
 
  }

}
