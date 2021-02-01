import React from "react";
import styled from 'styled-components';

function About() {

    const Heading = styled.h1`
        color: green;
        text-align: center;
    `;

    const Paragraph = styled.p`
        color: #2c2c2c;
        text-align: center;
    `;

    return(

        <div>
            <Heading>About Shop Local</Heading>

            <Paragraph>Shop Local is a site that was born in a time when gathering en mass has become , hopefully temporarily, a thing of the past.
                As businesses reopen as lockdown lifts, there will be a need to organise and track times that are available for consumers to be able to enter businesses.
                bla bla bla...
            </Paragraph>
        </div>
    )
}

export default About;