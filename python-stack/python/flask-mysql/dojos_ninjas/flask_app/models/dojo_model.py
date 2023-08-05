from flask_app.config.mysqlconnection import connectToMySQL




class Dojo:
    def __init__(self,data_dict):
        self.id = data_dict['id']
        self.name = data_dict['name']
        self.created_at = data_dict['created_at']
        
        self.updated_at = data_dict['updated_at']

    @classmethod
    def create(cls,data):
        query = """ INSERT into dojos (name) VALUES (%(name)s)"""

        return connectToMySQL(DB).query_db(query, data)
    
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM dojos"
        result = connectToMySQL(DB).query_db(query)
        all_dojos=[]
        for row in result:
            all_dojos.append(cls(row))
        return all_dojos    
        
        

