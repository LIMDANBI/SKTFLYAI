from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/mlops")
def hello_mlops():
    return "<p>Hello, MLOps!</p>"

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=5102) # debug 모드로 실행, 모든 IP 에서 접근 허용, 5102 포트로 사용하는 것을 의미

