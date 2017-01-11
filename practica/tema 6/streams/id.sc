object idExample {

  class User(var id: Int, var firstName: String, var lastName: String, var email: String, var supervisorId: Int) {}

  trait UserRepository {
    def get(id: Int): User
    def find(username: String): User
  }

  trait UserRepositoryComponent {

    def userRepository: UserRepository

    trait UserRepository {
      def get(id: Int): User
      def find(username: String): User
    }
  }

  trait Users {
    this: UserRepositoryComponent =>

    def getUser(id: Int): User = {
      userRepository.get(id)
    }

    def findUser(username: String): User = {
      userRepository.find(username)
    }
  }

  trait UserInfo extends Users {
    this: UserRepositoryComponent =>

    def userEmail(id: Int): String = {
      getUser(id).email
    }

    def userInfo(username: String): Map[String, String] = {
      val user = findUser(username)
      val boss = getUser(user.supervisorId)
      Map(
        "fullName" -> s"${user.firstName} ${user.lastName}",
        "email" -> s"${user.email}",
        "boss" -> s"${boss.firstName} ${boss.lastName}")
    }
  }

  trait UserRepositoryComponentImpl extends UserRepositoryComponent {

    def userRepository = new UserRepositoryImpl

    class UserRepositoryImpl extends UserRepository {

      var db: Map[Int, User] = Map()
      var dbUserName: Map[String, User] = Map()

      def save(user: User) = {
        db += (user.id -> user)
        dbUserName += (user.email -> user)
      }

      def get(id: Int) = db(id)

      def find(username: String) = dbUserName(username)

    }
  }
  
  object UserInfoImpl extends
  UserInfo with
  UserRepositoryComponentImpl

}