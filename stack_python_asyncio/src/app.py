from sanic import Sanic, response

app = Sanic(__name__)


@app.route('/')
async def hello(request):
    return response.text('Hello from the Python asyncio world!')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
