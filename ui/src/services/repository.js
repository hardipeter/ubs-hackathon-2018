const API_ADDRESS = 'http://localhost:8080/';

const commonFetchOptions = {
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json',
  },
  mode: 'cors',
};

export const callFetch = (path, options) => {
  return fetch(`${API_ADDRESS}${path}`, { ...commonFetchOptions, ...options });
};
