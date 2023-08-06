from flask import Flask

# ! CHANGE DATABASE NAME
DATABASE = 'emails'

app  = Flask(__name__)
app.secret_key = "shhhhhhhhhhhhhhh"