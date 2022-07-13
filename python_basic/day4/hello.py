from flask import Flask
app = Flask(__name__)

@app.route('/hello')
def helloworld():
    return 'Hello World'

@app.route('/ldb')
def ypjun():
    return 'My name is danbibibi'
app.add_url_rule('/jyp', 'my name', ypjun)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)