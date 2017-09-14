from flask import Flask  # Follow https://github.com/python/typeshed/issues/28 for type stub
app = Flask(__name__)


@app.route('/')
def hello() -> str:
    return 'Hello from the Python world!'


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
