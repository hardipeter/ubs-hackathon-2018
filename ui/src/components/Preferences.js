import React, { Component } from 'react';
import PreferencesRow from './PreferencesRow';

class Preferences extends Component {
  createPreferenceChangeHandler(id) {
    return value => {
      fetch(`http://localhost:3001/preferences/${id}`, {
        body: JSON.stringify({ levelOfInterest: value }),
        method: 'POST',
      }).then(() => {
        this.props.onChange();
      });
    };
  }

  render() {
    const { categories } = this.props;

    return (
      <div className="settings-container">
        {categories.map(category => {
          return (
            <div key={category.name}>
              <h3>{category.name}</h3>
              {category.preferences.map(preference => {
                const { _id, name, levelOfInterest } = preference;
                return (
                  <PreferencesRow
                    key={_id}
                    label={name}
                    value={levelOfInterest}
                    onPreferenceChange={this.createPreferenceChangeHandler(_id)}
                  />
                );
              })}
            </div>
          );
        })}
      </div>
    );
  }
}

export default Preferences;
