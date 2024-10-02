import React from 'react';
import {
  Container,
  Row,
  Col,
  Nav,
  NavItem,
  NavLink,
  Button,
  Card,
  CardBody,
  CardTitle,
} from 'reactstrap';
import { useNavigate } from 'react-router-dom';
import '../admin/AdminPanel.css'; // Optional: for custom styling

const AdminPanel = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    // Logic to handle logout
    alert('Logged out successfully!');
    navigate('/login'); // Redirect to login page
  };

  return (
    <Container fluid className="admin-panel">
      <Row>
        <Col md="3" className="sidebar">
          <h4 className="text-center">Admin Panel</h4>
          <Nav vertical className="mt-3">
            <NavItem>
              <NavLink href="/admin/dashboard">Dashboard</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/admin/users">Manage Users</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/admin/settings">Settings</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/admin/reports">Reports</NavLink>
            </NavItem>
            <NavItem>
              <Button color="danger" onClick={handleLogout} className="mt-3 w-100">
                Logout
              </Button>
            </NavItem>
          </Nav>
        </Col>
        <Col md="9">
          <Row>
            <Col>
              <h2 className="text-center mt-3">Welcome to the Admin Panel</h2>
              <Card className="mt-4">
                <CardBody>
                  <CardTitle tag="h5">Dashboard Overview</CardTitle>
                  <p>This is your admin dashboard where you can manage users, settings, and more.</p>
                </CardBody>
              </Card>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
  );
};

export default AdminPanel;
