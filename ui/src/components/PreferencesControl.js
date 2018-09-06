import React from 'react';
import { SegmentedControl } from 'segmented-control-react';

const preferenceValues = ['LOW', 'MEDIUM', 'HIGH'];

const getSelectedIndex = selectedValue =>
  preferenceValues.findIndex(value => value === selectedValue) || 0;

const PreferencesControl = ({ value, onChange }) => {
  const handleChange = index => {
    onChange(preferenceValues[index]);
  };

  const segments = [{ name: 'Low' }, { name: 'Medium' }, { name: 'High' }];

  return (
    <SegmentedControl
      segments={segments}
      selected={getSelectedIndex(value)}
      variant="dark"
      onChangeSegment={handleChange}
    />
  );
};

export default PreferencesControl;
