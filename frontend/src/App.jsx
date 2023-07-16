import React, { Suspense } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { Container } from "@mui/material";
import { NotificationContainer } from "react-notifications";
import { Applayout } from "./components/Layout/AppLayout";

function App() {
  return (
    <Suspense fallback={null}>
      <Container className="page-container">
        <Router>
          <Applayout></Applayout>
          <NotificationContainer />
        </Router>
      </Container>
    </Suspense>
  );
}

export default App;
