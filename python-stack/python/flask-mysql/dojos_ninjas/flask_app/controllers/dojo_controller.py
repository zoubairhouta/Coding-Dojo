from flask_app import app
from flask import render_template,redirect,request
from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import dojo_model
@app.route('/')
def index():
    all_dojos=dojo_model.Dojo.get_all()
    return render_template('index.html',dojos = all_dojos)
    

@app.route('/create_dojo',methods = ['POST'])
def create():
    query = """
    INSERT INTO dojos(name) VALUES (%(name)s)

"""
return connectToMySQL(DB).query_db(query)

