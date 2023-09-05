import React, { useState } from 'react';

const Form = (props) => {
  const { user, setUser } = props;

  const [errors, setErrors] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
  });

  const onChange = (event) => {
    const { name, value } = event.target;

    setUser({
      ...user,
      [name]: value,
    });

    setErrors({
      ...errors,
      [name]:
        (name === 'firstName' && value.length < 2 && value.trim() !== '') ||
        (name === 'lastName' && value.length < 2 && value.trim() !== '') ||
        (name === 'email' && value.length < 5 && value.trim() !== '') ||
        (name === 'password' && value.length < 8 && value.trim() !== '') ||
        (name === 'confirmPassword' && value !== user.password && value.trim() !== '')
          ? `${name.charAt(0).toUpperCase() + name.slice(1)} must ${
              name === 'confirmPassword' ? 'match' : 'be at least'
            } ${
              name === 'confirmPassword' ? 'password' : '2 characters'
            }`
          : '',
    });
  };

  return (
    <div className="container">
      <div className="row">
        <div className="input-group mb-3">
          <span className="input-group-text">First name</span>
          <input
            type="text"
            className="form-control"
            placeholder="First Name"
            name="firstName"
            value={user.firstName}
            onChange={onChange}
          />
          {errors.firstName && <p className="error">{errors.firstName}</p>}
        </div>
      </div>
      <div className="row">
        <div className="input-group mb-3">
          <span className="input-group-text">Last name</span>
          <input
            type="text"
            className="form-control"
            placeholder="Last Name"
            name="lastName"
            value={user.lastName}
            onChange={onChange}
          />
          {errors.lastName && <p className="error">{errors.lastName}</p>}
        </div>
      </div>
      <div className="row">
        <div className="input-group mb-3">
          <span className="input-group-text">Email</span>
          <input
            type="text"
            className="form-control"
            placeholder="Email"
            name="email"
            value={user.email}
            onChange={onChange}
          />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>
      </div>
      <div className="row">
        <div className="input-group mb-3">
          <span className="input-group-text">Password</span>
          <input
            type="password"
            className="form-control"
            placeholder="Password"
            name="password"
            value={user.password}
            onChange={onChange}
          />
          {errors.password && <p className="error">{errors.password}</p>}
        </div>
      </div>
      <div className="row">
        <div className="input-group mb-3">
          <span className="input-group-text">Confirm Password</span>
          <input
            type="password"
            className="form-control"
            placeholder="Confirm Password"
            name="confirmPassword"
            value={user.confirmPassword}
            onChange={onChange}
          />
          {errors.confirmPassword && (
            <p className="error">{errors.confirmPassword}</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Form;
