import React from 'react';
import {
  Container,
  Row,
  Col,
  Card,
  CardImg,
  CardBody,
  CardTitle,
  CardText,
  Button,
  FormGroup,
  Label,
  Input
} from 'reactstrap';

const MemberProfile = () => {
  const handleUpdate = () => {
    // Logic to handle profile update goes here
    alert('Profile updated!');
  };

  return (
    <Container className="my-5">
      <Card className="text-center">
        <CardImg
          top
          width="100%"
          src="https://via.placeholder.com/150" // Placeholder for profile photo
          alt="Profile Photo"
          className="rounded-circle mx-auto"
          style={{ width: '150px', height: '150px' }}
        />
        <CardBody>
          <CardTitle tag="h5">John Doe</CardTitle>
          <CardText>
            <Row>
              <Col>
                <strong>Contact:</strong> (123) 456-7890
              </Col>
              <Col>
                <strong>Email:</strong> john.doe@example.com
              </Col>
            </Row>
            <Row>
              <Col>
                <strong>Address:</strong> 123 Main St, City, Country
              </Col>
              <Col>
                <strong>Date of Birth:</strong> January 1, 1990
              </Col>
            </Row>
          </CardText>

          <FormGroup>
            <Label for="bio">Bio</Label>
            <Input type="textarea" id="bio" placeholder="Tell us about yourself..." />
          </FormGroup>

          <Button color="primary" onClick={handleUpdate}>
            Update Profile
          </Button>
        </CardBody>
      </Card>
    </Container>
  );
};

export default MemberProfile;
