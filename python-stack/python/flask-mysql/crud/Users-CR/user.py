from mysqlconnection import connectToMySQL

class User:
    DB = "userss"

    def __init__(self, data):
        self.id = data["id"]
        self.first_name = data["first_name"]
        self.last_name = data["last_name"]
        self.email = data["email"]
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL(cls.DB).query_db(query)
        users = []
        for user in results:
            users.append(cls(user))
        return users

    @classmethod
    def save(cls, data):
        query = """INSERT INTO friends (first_name, last_name, email)
                   VALUES (%(fname)s, %(lname)s, %(email)s);"""
        result = connectToMySQL(cls.DB).query_db(query, data)
        return result
