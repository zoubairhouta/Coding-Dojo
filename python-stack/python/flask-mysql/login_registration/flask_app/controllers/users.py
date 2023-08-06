from flask_app import app
from flask import render_template, request, redirect, session
from flask_app.models.user import User
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)


@app.route('/')
def index():
    return render_template("index.html")

@app.route('/dashboard')
def dashboard():
    return render_template("dashboard.html")

@app.route('/users/create', methods=['POST'])
def register():
    print("🔥"*20,request.form,"🔥"*20)
    if User.validate_register(request.form):
        pw_hash = bcrypt.generate_password_hash(request.form['password'])
        print("Password : ", request.form['password'])
        print("Hashed Password : ", pw_hash)
        data_dict = {
            **request.form,
            'password':pw_hash
        }
        # print(request.form,"--------------------")
        # print(data_dict,"**************************")
        # b'$2b$12$PQzrVLpEuqq8YZOA0RAKo.u3X9.1pDGtannCoANYulfQpbhvCano6 == 1111111
        User.create(data_dict)
        return redirect('/dashboard')
    return redirect('/')

@app.route('/login', methods =['POST'])
def login():
    print(request.form)
    return redirect('/')
