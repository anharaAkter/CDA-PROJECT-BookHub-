
import { useState, useEffect } from "react"
import { Link as RouterLink } from "react-router-dom"
import {
     Button,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Modal,
    Card,
    CardContent,
    TablePagination,
    Typography

} from "@mui/material"
import classes from "./styles.module.css"

export const BooksList = () => {
    const [books, setBooks] = useState([]);
    const [openModal, setOpenModal] = useState(false)
    const [page, setPage] = useState(0)
    const [rowsPerPage, setRowsPerPage] = useState(10)


    console.log(books);
    const fetchBooks = async () => {
        try {
            let response = await fetch(`http://localhost:8080/books`);

            if (!response.ok) {
                throw new Error('Not a valid response');
            }

            let bookList = await response.json();
            console.log(bookList);
            setBooks(bookList);

        } catch (err) {
            console.warn(err.message);
        }
    };

    useEffect(() => {
        fetchBooks();
    }, [])


    return (
        <>
            <div className={`${classes.pageHeader} ${classes.mb2}`}>
                <Typography variant="h5">Book List</Typography>
            </div>
            {books.length > 0 ? (
                <>
                    <div className={classes.tableContainer}>
                        <TableContainer component={Paper}>
                            <Table stickyHeader>
                                <TableHead>
                                    <TableRow>
                                        <TableCell >Book Name</TableCell>
                                        <TableCell >Book CODE</TableCell>
                                        <TableCell >Quantity</TableCell>
                                        <TableCell >Description</TableCell>
                                        <TableCell >Publish Date</TableCell>

                                        <TableCell>Action</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {(rowsPerPage > 0
                                        ? books.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                                        : books
                                    ).map((book) => (
                                        <TableRow key={book.bookId}>
                                            <TableCell component="th" scope="row">
                                                {book.title}
                                            </TableCell>
                                            <TableCell>{book.bookId}</TableCell>
                                            <TableCell >{book.copiesOwned}</TableCell>
                                            <TableCell >{book.description}</TableCell>
                                            <TableCell >{`${book.publishDate}`}</TableCell>
                                            <TableCell>
                                                <div className={classes.actionsContainer}>
                                                    <Button
                                                        variant="contained"
                                                        component={RouterLink}
                                                        size="small"
                                                        to={`/books/${book.bookId}`}
                                                    >
                                                        View
                                                    </Button>

                                                </div>
                                            </TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer>
                        <TablePagination
                            onRowsPerPageChange={(e) => {
                                setRowsPerPage(parseInt(e.target.value, 10))
                                setPage(0)
                            }}
                            component="div"
                            count={books.length}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            onPageChange={(e, newPage) => setPage(newPage)}
                        />

                        <Modal open={openModal} onClose={(e) => setOpenModal(false)}>
                            <Card className={classes.conf_modal}>
                                <CardContent>
                                    <h2>Are you sure?</h2>
                                </CardContent>

                            </Card>
                        </Modal>
                    </div>
                </>
            ) : (
                <Typography variant="h5">No books found!</Typography>
            )}


        </>
    )
}

