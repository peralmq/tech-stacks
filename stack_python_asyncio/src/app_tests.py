import unittest
from app import app


class TestApp(unittest.TestCase):
    def test_hello(self):
        request, response = app.test_client.get('/')
        assert response.status == 200
        assert response.text == 'Hello from the Python asyncio world!'


if __name__ == '__main__':
    unittest.main()
