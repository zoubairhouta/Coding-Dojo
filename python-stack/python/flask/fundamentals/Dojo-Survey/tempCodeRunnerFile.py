from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)

app.secret_key = 'mouniralebnina'

@app.route("/", methods=["GET", "POST"])
def form_page():
    if request.method == "POST":
        # Retrieve form data and store it in session
        session['first_name'] = request.form['FirstName']
        session['last_name'] = request.form['LastName']
        session['country'] = request.form['Country']
        session['city'] = request.form['City']
        session['zip'] = request.form['Zip']
        session['comments'] = request.form['Comments']
        return redirect("/result")
    return render_template("index.html")

@app.route("/result")
def result_page():
    first_name = session.get('first_name', '')
    last_name = session.get('last_name', '')
    country = session.get('country', '')
    city = session.get('city', '')
    zip_code = session.get('zip', '')
    comments = session.get('comments', '')
    return render_template("result.html", first_name=first_name, last_name=last_name, country=country, city=city, zip_code=zip_code, comments=comments)

if __name__ == "__main__":
    app.run(debug=True, port=5004)