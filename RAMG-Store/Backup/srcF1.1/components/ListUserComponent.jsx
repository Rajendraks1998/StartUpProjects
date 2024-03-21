import React, {useState, useEffect} from 'react'
import { listUsers, deleteUser } from '../services/UserService'
import { useNavigate } from 'react-router-dom'
import { isAdminUser } from '../services/AuthService'


const ListUserComponent = () => {
    const [users, setUsers] = useState([])
    
    useEffect(() => {
       getAllUsers();
    }, [])


    const navigator = useNavigate();

    const isAdmin = isAdminUser();

    function getAllUsers() {
        listUsers().then((response) => {
            setUsers(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewUser(){
        navigator('/add-user')
    }

    function updateUser(id){
        navigator(`/edit-user/${id}`)
    }

    function removeUser(id){
        deleteUser(id).then((response) => {
            getAllUsers();
        }).catch(error => {
            alert(error.message);
        })
    }
  return (
    <div className='container'>
      <h2 className='text-center'>List of Users</h2>
      {
        isAdmin && <button className='btn btn-primary mb-2' onClick={addNewUser}>Add User</button>
      }
      
      
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>Store Name</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Email Id</th>
                <th>Password</th>
                {
                    isAdmin && <th>Action</th>
                }
                
            </tr>
        </thead>
        <tbody>
            {
                users.map(user =>
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.name}</td>
                        <td>{user.store}</td>
                        <td>{user.address}</td>
                        <td>{user.contact}</td>
                        <td>{user.email}</td>
                        <td>{user.password}</td>
                        <td>
                            {
                                isAdmin && 
                                <button className='btn btn-info' onClick={()=> updateUser(user.id)}>Update</button>
                            }
                            {
                                isAdmin &&
                                <button className='btn btn-danger' onClick={()=> removeUser(user.id)}
                                style={{marginLeft:'10px'}}
                                >Delete</button>
                            }
                        
                        </td>
                    </tr>
                )
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListUserComponent
