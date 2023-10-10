import { useState, useEffect, createContext, useContext } from "react"


const UserContext = createContext({
    user: null,
    loginUser: () => { },
})

const useUser = () => useContext(UserContext);

const UserProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [isAdmin, setIsAdmin] = useState(false);


    useEffect(() => {
        setIsAdmin(user && user.role === 'admin')
    }, [user])



}
