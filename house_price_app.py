import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn.preprocessing import LabelEncoder
import streamlit as st

# Load and preprocess the dataset
def load_data():
    df = pd.read_csv('Bengaluru_House_Data.csv')
    # Drop unnecessary columns
    df = df.drop(['area_type', 'availability', 'society'], axis=1)
    # Handle missing values
    df = df.dropna()
    
    # Convert 'size' to numerical (e.g., "2 BHK" -> 2)
    df['bhk'] = df['size'].apply(lambda x: int(x.split(' ')[0]))
    df = df.drop('size', axis=1)
    
    # Clean 'total_sqft' (handle ranges like "1133 - 1384")
    def convert_sqft_to_num(x):
        tokens = x.split('-')
        if len(tokens) == 2:
            return (float(tokens[0]) + float(tokens[1])) / 2
        try:
            return float(x)
        except:
            return None
    df['total_sqft'] = df['total_sqft'].apply(convert_sqft_to_num)
    df = df.dropna()
    
    # Encode categorical 'location'
    le = LabelEncoder()
    df['location'] = le.fit_transform(df['location'])
    
    return df, le

# Train the model
def train_model(df):
    X = df.drop('price', axis=1)
    y = df['price']
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    
    model = RandomForestRegressor(n_estimators=100, random_state=42)
    model.fit(X_train, y_train)
    score = model.score(X_test, y_test)
    return model, score

# Streamlit UI
def main():
    st.title("Bengaluru House Price Prediction")
    st.write("Enter house details to predict the price (in Lakhs INR)")

    # Load data and model
    df, le = load_data()
    model, score = train_model(df)
    st.write(f"Model Accuracy: {score:.2%}")

    # User inputs
    locations = le.classes_
    location = st.selectbox("Location", locations)
    total_sqft = st.number_input("Total Square Feet", min_value=300.0, max_value=10000.0, value=1000.0)
    bhk = st.slider("Number of Bedrooms (BHK)", min_value=1, max_value=10, value=2)
    bath = st.slider("Number of Bathrooms", min_value=1, max_value=10, value=2)
    balcony = st.slider("Number of Balconies", min_value=0, max_value=5, value=1)

    # Predict price
    if st.button("Predict Price"):
        # Prepare input data
        location_encoded = le.transform([location])[0]
        input_data = np.array([[location_encoded, total_sqft, bath, balcony, bhk]])
        
        # Make prediction
        prediction = model.predict(input_data)[0]
        st.success(f"Predicted Price: {prediction:.2f} Lakhs INR")

if __name__ == "__main__":
    main()