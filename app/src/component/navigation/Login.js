import React, { useState } from 'react';
import {
  Container,
  Row,
  Col,
  Input,
  Button,
  Form,
  FormGroup,
  Label,
  ButtonGroup,
} from 'reactstrap';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../navigation/Login.css';

const Login = () => {
  const [emailAddress, setEmailAddress] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('member'); // Default role
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    // Set the correct URL based on the role
    const baseURL = 'http://localhost:8080/api/amazingcode.in.tms.club';
    const url = role === 'admin' ? `${baseURL}/admin/login` : `${baseURL}/member/login`;

    try {
      const response = await axios.post(url, {
        emailAddress,
        password,
      });

      if (response.data.success) {
        // Redirect based on role
        if (role === 'admin') {
          navigate('/admin-panel'); // Redirect to admin panel
        } else {
          navigate('/member/profile'); // Redirect to member profile
        }
      } else {
        alert('Invalid credentials!');
      }
    } catch (error) {
      console.error('Error during login:', error);
      alert('Login failed! Please try again.');
    }
  };

  return (
    <Container fluid className="my-5">
      <Row className="h-100 justify-content-center align-items-center">
        <Col md="6" className="login-container">
          <h4 className="text-center">Welcome to Our Application</h4>
          <ButtonGroup className="mb-4 d-flex justify-content-center">
            <Button
              color={role === 'member' ? 'primary' : 'secondary'}
              onClick={() => setRole('member')}
              size="lg"
              className="flex-fill"
            >
              Member
            </Button>
            <Button
              color={role === 'admin' ? 'primary' : 'secondary'}
              onClick={() => setRole('admin')}
              size="lg"
              className="flex-fill"
            >
              Admin
            </Button>
          </ButtonGroup>
          <Form onSubmit={handleLogin}>
            <FormGroup>
              <Label for="email">Email address</Label>
              <Input
                type="email"
                id="email"
                value={emailAddress}
                onChange={(e) => setEmailAddress(e.target.value)}
                required
              />
            </FormGroup>
            <FormGroup>
              <Label for="password">Password</Label>
              <Input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </FormGroup>
            <Button type="submit" color="primary" className="w-100" size="lg">
              Log in
            </Button>
          </Form>
          <div className="text-center mt-3">
            <p>
              Not registered?{' '}
              <Button color="link" onClick={() => navigate('/register')}>
                Register Here
              </Button>
            </p>
          </div>
        </Col>
      </Row>
    </Container>
  );
};

export default Login;
