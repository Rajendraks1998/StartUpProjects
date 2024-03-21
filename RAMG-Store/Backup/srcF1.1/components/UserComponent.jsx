import React, { useEffect, useState } from 'react'
import { createUser, getUser, updateUser } from '../services/UserService';
import { useNavigate, useParams } from 'react-router-dom';

const UserComponent = () => {

  const [name, setName] = useState('');
  const [store, setStore] = useState('');
  const [address, setAddress] = useState('');
  const [contact, setContact] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const navigator = useNavigate();

  const {id} = useParams();

  useEffect(() =>{
    if(id){
      getUser(id).then((response) => {
        setName(response.data.name);
        setStore(response.data.store);
        setAddress(response.data.address);
        setContact(response.data.contact);
        setEmail(response.data.email);
        setPassword(response.data.password);
      }).catch(error => {
        console.error(error);
      })
    }
  },[id])

  function saveOrUpdateUser(e) {
    e.preventDefault();
    
    if(validateForm()){

      const user = { name,store,address,contact,email,password }
      console.log(user);
      if(id){
        updateUser(id, user).then((response) => {
          console.log(response.data);
          navigator('/users');
        }).catch(error => {
          alert(error.message);
          navigator('/users');
        })
      }else{
        createUser(user).then((response) => {
          console.log(response.data);
          navigator('/users');
        }).catch(error => {
          alert(error.message);
          navigator('/users');
        })
      }
    }
    
  }

  function pageTitle(){
    if(id){
      return <h2 className='text-center'>Update User</h2>
    }else{
      return <h2 className='text-center'>Add User</h2>
    }
  }

  const [errors, setErrors] = useState({
    name: '',
    store: '',
    address: '',
    contact: '',
    email: '',
    password: ''
  })

  function validateForm(){
    let valid = true;
    const errorsCopy = {... errors}

    if(name.trim()){
      errorsCopy.name='';
    }else{
      errorsCopy.name='Name is required';
      valid=false;
    }
    if(store.trim()){
      errorsCopy.store='';
    }else{
      errorsCopy.store='store is required';
      valid=false;
    }
    if(address.trim()){
      errorsCopy.address='';
    }else{
      errorsCopy.address='address is required';
      valid=false;
    }
    if(contact!=null){
      errorsCopy.contact='';
    }else{
      errorsCopy.contact='contact is required';
      valid=false;
    }
    if(email.trim()){
      errorsCopy.email='';
    }else{
      errorsCopy.email='email is required';
      valid=false;
    }
    if(password.trim()){
      errorsCopy.password='';
    }else{
      errorsCopy.password='password is required';
      valid=false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  return (
    <div className='container'>
      <br></br>
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          {
            pageTitle()
          }
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-group'>Name</label>
                <input
                type='text'
                placeholder='Enter your name'
                name='name'
                value={name}
                className={`form-control ${errors.name? 'is-invalid': ''}`}
                onChange={(e)=> setName(e.target.value)}
                >
                </input>
                {errors.name && <div className='invalid-feedback'>{errors.name}</div>}
                <label className='form-group'>Store name</label>
                <input
                type='text'
                placeholder='Enter your Store name'
                name='store'
                value={store}
                className={`form-control ${errors.store? 'is-invalid': ''}`}
                onChange={(e)=> setStore(e.target.value)}
                >
                </input>
                {errors.store && <div className='invalid-feedback'>{errors.store}</div>}
                <label className='form-group'>Address</label>
                <input
                type='text'
                placeholder='Enter your Address'
                name='address'
                value={address}
                className={`form-control ${errors.address? 'is-invalid': ''}`}
                onChange={(e)=> setAddress(e.target.value)}
                >
                </input>
                {errors.address && <div className='invalid-feedback'>{errors.address}</div>}
                <label className='form-group'>Contact</label>
                <input
                type='text'
                placeholder='Enter your Contact Number'
                name='contact'
                value={contact}
                className={`form-control ${errors.contact? 'is-invalid': ''}`}
                onChange={(e)=> setContact(e.target.value)}
                >
                </input>
                {errors.contact && <div className='invalid-feedback'>{errors.contact}</div>}
                <label className='form-group'>Email Id</label>
                <input
                type='email'
                placeholder='Enter your email'
                name='email'
                value={email}
                className={`form-control ${errors.email? 'is-invalid': ''}`}
                onChange={(e)=> setEmail(e.target.value)}
                >
                </input>
                {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                <label className='form-group'>Password</label>
                <input
                type='password'
                placeholder='Enter your Password'
                name='password'
                value={password}
                className={`form-control ${errors.password? 'is-invalid': ''}`}
                onChange={(e)=> setPassword(e.target.value)}
                >
                </input>
                { errors.password && <div className='invalid-feedback'>{errors.password}</div>}
              </div>
              <button className='btn btn-success' onClick={saveOrUpdateUser}>Submit</button>
            </form>
          </div>
        </div> 
      </div>
    </div>
  )
}

export default UserComponent
