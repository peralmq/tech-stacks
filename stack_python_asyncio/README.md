# Python asyncio tech stack
Stack based on
* [Python 3.6](https://docs.python.org/3/whatsnew/3.6.html)
* [asyncio PEP-3156](https://www.python.org/dev/peps/pep-3156/) - asynchronous I/O support in standard library
* [Sanic](http://sanic.readthedocs.io/) - a micro web framework
* [pip3](https://packaging.python.org/key_projects/#pip) - Python package installer

## Usage
```
> curl localhost:9004
Hello from the Python asyncio world!
> curl localhost:9002/db
Connected to the database
```

## Local development
```
python3 -m pip install -r requirements.txt
python3 src/app.py
```

### Tests
```
python3 -m unittest discover -s src -p "*_tests.py"
```
