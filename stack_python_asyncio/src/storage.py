import re
from aiomysql.sa import create_engine


class Storage:
    PATTERN = re.compile(r'^mysql://(?P<user>.+):(?P<password>.+)@(?P<host>.+)/(?P<db>.+)$')

    def __init__(self, connection_string):
        self.connection_dict = self.PATTERN.match(connection_string).groupdict()

    async def status_ok(self):
        try:
            async with create_engine(**self.connection_dict) as engine:
                async with engine.acquire() as connection:
                    resultProxy = await connection.execute('SELECT 1')
                    result = await resultProxy.first()
                    return result and result[0] == 1
        except:
            raise

        return False
