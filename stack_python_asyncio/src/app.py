from sanic import Sanic, response
from storage import Storage
app = Sanic(__name__)
db = Storage('mysql://ts_user:ts_pw@db_mysql/ts_db')


@app.route('/db')
async def hello_db(request):
    if await db.status_ok():
        return response.text('Connected to database')

    return response.text('Not connected to database')


@app.route('/')
async def hello(request):
    return response.text('Hello from the Python asyncio world!')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080, debug=True)
