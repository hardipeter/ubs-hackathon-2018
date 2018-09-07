import React from 'react';
import PreferencesControl from './PreferencesControl';

const PreferencesRow = ({ key, label, value, onPreferenceChange }) => {
  return (
    <div className="row">
      <div className="label-column">{label}</div>
      <div className="slider-column">
        <PreferencesControl value={value} onChange={onPreferenceChange} />
      </div>
    </div>
  );
};

export default PreferencesRow;
