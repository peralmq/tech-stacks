# Python tech stack
Stack based on
* [Python 3.6](https://docs.python.org/3/whatsnew/3.6.html)
* [Flask](http://flask.pocoo.org/) - a micro web framework
* [SQLAlchemy Core](http://docs.sqlalchemy.org/en/latest/core/) - a database connector (Note, we're NOT using the ORM part of SQLAlchemy)
* [pip3](https://packaging.python.org/key_projects/#pip) - Python package installer

## Usage
```
> curl localhost:9002
Hello from the Python world!
> curl localhost:9002/db
Connected to the database
```

## Local development
```
python3 -m pip install -r requirements.txt
python3 src/app.py
```

## Other
We dropped static type hints and checking because it's not mature enough.

So, we're NOT using:
* [PEP-484](https://www.python.org/dev/peps/pep-0484/) - (static) type hints within Python
* [mypy](http://mypy-lang.org/) - static type checker that make use of PEP-484
