from flask_app import app

# ! DONT FORGET TO IMPORT CONTROLLERS
from flask_app.controllers import emails



if __name__ =="__main__":
    app.run(debug=True, port=5001)