from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE
from flask import flash
import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 
class Email:
    def __init__(self,data_dict):
        self.id = data_dict['id']
        self.email = data_dict['email']
        self.created_at = data_dict['created_at']
        self.updated_at = data_dict['updated_at']




#Now we are going to do queries 

#=================CRUD====================



#=================Create====================

    @classmethod
    def create(cls,data):

        query = """INSERT INTO emails (email) VALUES (%(email)s);"""
        return connectToMySQL(DATABASE).query_db(query,data)
    
#===================READ ALL==========================


    @classmethod
    def get_all(cls):
        query = """SELECT * FROM emails;"""
        results = connectToMySQL(DATABASE).query_db(query)
        emails = []
        for row in results:
            emails.append(cls(row))
        return emails
#=================READ ONE==========================

    @classmethod
    def get_one(cls, data_dict):
        query =  """SELECT * FROM emails WHERE id = %(id)s;"""
        result = connectToMySQL(DATABASE).query_db(query, data_dict)
        # print("**********************",result,"**********************")
        return cls(result[0])
#================Update===============
    @classmethod
    def update(cls,data):
        query="""UPDATE emails SET email=%(email)s WHERE id =%(id)s;"""
        return connectToMySQL(DATABASE).query_db(query,data)

#=================DELETE===============================
    @classmethod
    def destroy(cls,data):
        query="""DELETE FROM emails WHERE id=%(id)s;"""
        return connectToMySQL(DATABASE).query_db(query,data)
    


    #======Static Methods for validation ========


    @staticmethod
    def validate_email(email):
        is_valid = True # we assume this is true
        if len(email)>54:
            flash("Yesser ezzebby")
            is_valid = False
        is_valid = True
        if not EMAIL_REGEX.match(email): 
            flash("Invalid email address!")
            is_valid = False

        return is_valid