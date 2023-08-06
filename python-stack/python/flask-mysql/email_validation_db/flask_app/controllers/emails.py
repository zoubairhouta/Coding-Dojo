from flask import render_template, request, redirect
from flask_app import app
from flask_app.models.email import Email



@app.route('/')

def index():
    emails = Email.get_all()
    return render_template("index.html",emails=emails)

@app.route('/create',methods=['POST'])
def create():
    data_dict = {
        'email': request.form['email'],
    }
    print(data_dict)
    # print("***********")
    # print(len(email['email']))
    # print("***********")
    # print(len(data_dict['email']))
    print(request.form['email'])
    if not Email.validate_email(request.form['email']):
        return redirect('/')
    Email.create(data_dict)
    return redirect('/')



@app.route('/<int:email_id>')
def one_email(email_id):
    one_email = Email.get_one({'id':email_id})
    return render_template("one_email.html", email = one_email )


@app.route('/<int:email_id>/edit')
def edit_quote(email_id):
    one_email = Email.get_one({'id': email_id})
    return render_template("edit.html", email = one_email)
@app.route('/<int:email_id>/update', methods=["POST"])
def update(email_id):
    print(request.form)
    data = {
        **request.form,
        'id':email_id
    }
    print(data)
    Email.update(data)
    return redirect('/')
@app.route('/<int:email_id>/destroy', methods=['POST'])
def destroy(email_id):
    Email.destroy({'id':email_id})
    return redirect('/')
