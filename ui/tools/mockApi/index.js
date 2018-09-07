const express = require('express');
const preferences = require('./preferences');
const holdings = require('./holdings');

const app = express();
const port = 8080;

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

app.get('/clients/ranking', (request, response, next) => {
  response.setHeader('Access-Control-Allow-Origin', '*');
  response.json(2.8361304).send();
  return next();
});

app.get('/clients/holdings', (request, response, next) => {
  response.setHeader('Access-Control-Allow-Origin', '*');
  response.status(200).send(holdings);
  return next();
});

app.post('/client/holdings/remove/:id', (request, response, next) => {
  response.setHeader('Access-Control-Allow-Origin', '*');
  response.status(200).send({});
  return next();
});

app.listen(port);
