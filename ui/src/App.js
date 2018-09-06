import React, { Component } from 'react';
import './App.css';
import Preferences from './components/Preferences';
import { callFetch } from './services/repository';

const getRandomColorCode = () => {
  return Math.floor(Math.random() * 1000000);
};

class App extends Component {
  state = {
    data: null,
    color: getRandomColorCode(),
  };

  componentDidMount() {
    callFetch('preferences')
      .then(response => response.json())
      .then(data => {
        this.setState({ data });
      });
  }

  handlePreferencesChange = () => {
    this.setState({ color: getRandomColorCode() });
  };

  renderContent() {
    const { data, color } = this.state;
    if (!data) {
      return <div className="spinner" />;
    }

    const { categories } = data;
    return (
      <div className="content-container">
        <Preferences
          categories={categories}
          onChange={this.handlePreferencesChange}
        />
        <div style={{ flex: 1, background: `#${color}` }} />
      </div>
    );
  }

  render() {
    return <div className="container">{this.renderContent()}</div>;
  }
}

export default App;
