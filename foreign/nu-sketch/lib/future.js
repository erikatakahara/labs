"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.autoSum = exports.sum = void 0;

const sum = (x, y) => {
  console.log("Executando a função ...");
  return x + y;
};

exports.sum = sum;

const autoSum = () => 1 + 2;

exports.autoSum = autoSum;