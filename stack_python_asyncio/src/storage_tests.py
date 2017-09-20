import asyncio
import unittest
from storage import Storage


def async_test(f):
    def wrapper(*args, **kwargs):
        loop = asyncio.new_event_loop()
        return loop.run_until_complete(f(*args, **kwargs))
    return wrapper


class TestStorage(unittest.TestCase):
    @async_test
    async def test_status_ok(self):
        connection_string = 'mysql://services:IAmATeapot57@127.0.0.1/services'
        db = Storage(connection_string)
        assert await db.status_ok()


if __name__ == '__main__':
    unittest.main()
