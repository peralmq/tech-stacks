FROM python:3.6

EXPOSE 8080

COPY requirements.txt /src/requirements.txt
RUN python3 -m pip install -r src/requirements.txt

COPY src/ /src/

WORKDIR /src

CMD ["python3", "app.py"]
