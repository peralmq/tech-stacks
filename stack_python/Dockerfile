FROM python:3.6

EXPOSE 8080

COPY requirements.txt /src/requirements.txt
RUN pip install -r src/requirements.txt

COPY src/ /src/

# Changing directory for not messing up PATH when testing
WORKDIR /src

#CMD ["uwsgi", \
#     "-s", "0.0.0.0:8080", \
#     "--master", \
#     "--manage-script-name", \
#     "--mount", "/=app:app"]

CMD python3 app.py
