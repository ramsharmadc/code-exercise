function logRandom() {
    console.log(Math.random());
}

function Button(props) {

    const handleClick = () =>
        props.onClickIncrementFn(props.incrementFactor);
    return (
        <button
            onClick={handleClick}
        >
            {props.incrementFactor}
        </button>
    );
}

function Display(props) {
    return (
        <div>{props.message}</div>
    );
}

function App() {
    const [counter, setCounter] = useState(42);
    const incrementByFn = (incrementVal) => setCounter(counter + incrementVal)
    return (
        <div>
            <Button
                onClickIncrementFn={incrementByFn} incrementFactor={5} />
            <Button
                onClickIncrementFn={incrementByFn} incrementFactor={2} />
            <Button
                onClickIncrementFn={incrementByFn} incrementFactor={3} />
            <Button
                onClickIncrementFn={incrementByFn} incrementFactor={10} />
            <Display message={counter} />
        </div>
    );
}

ReactDOM.render(
    <App />,
    document.getElementById('mountNode'),
);