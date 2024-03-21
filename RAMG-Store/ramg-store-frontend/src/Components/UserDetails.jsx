// src/components/UserDetails.js
import React from 'react';

const UserDetails = ({ user }) => {
  return (
    <div>
      <p>Username: {user.username}</p>
      {/* Add more user details here if needed */}
    </div>
  );
};

export default UserDetails;
