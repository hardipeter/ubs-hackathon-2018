import React from 'react';
import PreferencesControl from './PreferencesControl';

const PreferencesRow = ({ id, label, value, onPreferenceChange }) => {
  return (
    <div className="row">
      <img src={`/pref${id}.png`} />
      <div className="label-column">{label}</div>
      <div className="slider-column">
        <PreferencesControl value={value} onChange={onPreferenceChange} />
      </div>
    </div>
  );
};

export default PreferencesRow;
