import { Link, Routes, Route, Navigate } from "react-router-dom";
import { useState } from "react";
import {
  AppBar,
  Container,
  Box,
  Toolbar,
  Typography,
  Tooltip,
  Button
} from "@mui/material";

import MenuBookIcon from '@mui/icons-material/MenuBook';
import { BooksList } from "../BookList/BookList";
import { LoginDialog } from "../Login/LoginDialog";
export const Applayout = () => {

  const [openLoginDialog, setOpenLoginDialog] = useState(false);

  const handleLoginSubmit = (username, password) => {
    setOpenLoginDialog(false)
    console.log(username, password)

  }
  const handleLoginClose = () => {
    setOpenLoginDialog(false)

  }

  return (
    <>
      <AppBar position="static">
        <Container maxWidth="xl">
          <Toolbar disableGutters>
            <MenuBookIcon sx={{ display: "flex", mr: 1 }} />
            <Link to="/" style={{ textDecoration: "none", flexGrow: 1 }}>
              <Typography
                variant="h6"
                noWrap
                sx={{
                  mr: 2,
                  display: "flex",
                  fontFamily: "monospace",
                  fontWeight: 700,
                  letterSpacing: ".3rem",
                  color: "white",
                }}
              >
                BookHub
              </Typography>
            </Link>
            <Box
              sx={{
                flexGrow: 0,
              }}
            >
              <>
                <Tooltip title="Open settings">

                </Tooltip>


                <Button
                  onClick={() => {
                    setOpenLoginDialog(true)
                  }}
                  sx={{ my: 2, color: "white", display: "block" }}
                >
                  Login
                </Button>
              </>
            </Box>
          </Toolbar>
        </Container>
      </AppBar >
      <Routes>
        <Route path="/books" exact element={<BooksList />} />
        <Route path="*" element={<Navigate to="/books" replace />} />
      </Routes>
      <LoginDialog open={openLoginDialog} handleSubmit={handleLoginSubmit} handleClose={handleLoginClose}></LoginDialog>
    </>
  );
};
