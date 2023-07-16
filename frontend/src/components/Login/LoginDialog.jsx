import { useState, forwardRef } from 'react';
import {
    Button,
    TextField,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    Slide

} from '@mui/material';



const Transition = forwardRef(function Transition(props, ref) {
    return <Slide direction="up" ref={ref} {...props} />
})

export const LoginDialog = ({ open, handleClose, handleSubmit }) => {

    const [username, setusername] = useState("")
    const [password, setpassword] = useState("")

    const onSubmit = (event) => {
        event.preventDefault()
        handleSubmit(username, password)

    }
    const handleEnterKeyDown = (event) => {
        if (event.key === "Enter") {
            onSubmit(event)
        }
    }

    return (

        <Dialog open={open}
            onClose={handleClose}
            onKeyDown={handleEnterKeyDown} TransitionComponent={Transition} >
            <DialogTitle>Log In</DialogTitle>
            <DialogContent>

                <TextField
                    autoFocus
                    margin="dense"
                    id="username"
                    label="Username"
                    type="text"
                    fullWidth
                    variant="standard"
                    value={username}
                    onChange={(e) => setusername(e.target.value)}
                />
                <TextField
                    margin="dense"
                    id="password"
                    label="Password"
                    type="password"
                    fullWidth
                    variant="standard"
                    value={password}
                    onChange={(e) => setpassword(e.target.value)}
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose}>Cancel</Button>
                <Button onClick={onSubmit}>Submit</Button>
            </DialogActions>
        </Dialog>

    );
}