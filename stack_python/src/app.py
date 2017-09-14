from flask import Flask
from sqlalchemy import create_engine

app = Flask(__name__)


@app.route('/db')
def hello_db():
    try:
        db = create_engine('mysql://ts_user:ts_pw@db_mysql/ts_db', strategy='threadlocal')
        result = db.execute('SELECT 1').first()
        if result and result[0] == 1:
            return 'Connected to database'
    except:
        pass

    return 'Not connected to database'


@app.route('/')
def hello():
    return 'Hello from the Python world!'


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
