from sanic import Sanic, response
from aiomysql.sa import create_engine

app = Sanic(__name__)


@app.route('/db')
async def hello_db(request):
    try:
        async with create_engine(
            user='ts_user',
            password='ts_pw',
            host='db_mysql',
            db='ts_db'
        ) as engine:
            async with engine.acquire() as connection:
                resultProxy = await connection.execute('SELECT 1')
                result = await resultProxy.first()
                if result and result[0] == 1:
                    return response.text('Connected to database')
    except:
        pass

    return response.text('Not connected to database')


@app.route('/')
async def hello(request):
    return response.text('Hello from the Python asyncio world!')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080, debug=True)
