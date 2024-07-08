import { useForm } from "react-hook-form";
//import { useForm } from 'react-hook-form';
function Form2() {
    const {register, handleSubmit} = useForm();

    function onSubmitButton(data) {
        console.log(data)
    }

    return (
        <>
            <h1>Order weather</h1>
            <form onSubmit={handleSubmit(onSubmitButton)}>
                <input
                    {...register("fullName")}
                    type="text"
                    placeholder="Name and surname"
                    id="name"
                />
                <input
                    {...register("city")}
                    type="text"
                    placeholder="City"
                    id="city"
                />
                <p>I would like to:</p>
                <label htmlFor="field-rain">
                    <input
                        {...register("weather")}
                        type="radio"
                        value="rain"
                        id="field-rain"
                    />
                    Rain
                </label>
                <label htmlFor="field-wind">
                    <input
                        {...register("weather")}
                        type="radio"
                        value="wind"
                        id="field-wind"
                    />
                    Lots of wind
                </label>
                <label htmlFor="field-sun">
                    <input
                        {...register("weather")}
                        type="radio"
                        value="sun"
                        id="field-sun"
                    />
                    Sunny
                </label>
                <button type="submit">
                    Send
                </button>
            </form>
        </>
    );
}

export default Form2;
