from flask import Flask, render_template, redirect, request
from user import User

app = Flask(__name__)

@app.route("/")
def index():
    users = User.get_all()  # Corrected the class name to "User" instead of "Users"
    print(users)
    return render_template("Read (All).html", all_users=users)

@app.route('/users/create', methods=['POST'])
def create():
    User.save(request.form)  # Corrected the class name to "User" instead of "Users"
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)
