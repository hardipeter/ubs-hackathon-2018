const express = require('express');
const preferences = require('./preferences');

const app = express();
const port = 3001;

const TIMEOUT = 500;
const delay = (req, res, next) => setTimeout(next, TIMEOUT);

app.use(delay);

app.get('/preferences', (request, response, next) => {
  response.setHeader('Access-Control-Allow-Origin', '*');
  response.status(200).send(preferences);
  return next();
});

app.post('/preferences/:id', (request, response, next) => {
  response.setHeader('Access-Control-Allow-Origin', '*');
  response.status(200).send({});
  return next();
});

app.listen(port);
