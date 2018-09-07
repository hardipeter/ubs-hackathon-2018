import React, { Component } from 'react';
import PreferencesRow from './PreferencesRow';
import { callFetch } from '../services/repository';

class Preferences extends Component {
  createPreferenceChangeHandler(id) {
    console.log('handlePreferenceChange');
    return value => {
      callFetch(`preferences/${id}`, {
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
                const { id, name, levelOfInterest } = preference;
                return (
                  <PreferencesRow
                    key={id}
                    label={name}
                    value={levelOfInterest}
                    onPreferenceChange={this.createPreferenceChangeHandler(id)}
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
