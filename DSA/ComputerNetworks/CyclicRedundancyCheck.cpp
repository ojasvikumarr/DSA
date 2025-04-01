#include <iostream>
#include <vector>
#include <bitset>
using namespace std;

class CRC {
public:

    static string crcCheck(string data, string divisor) {
        // Append 0's to data (degree of the divisor)
        string paddedData = data + string(divisor.size() - 1, '0');
        
        // Perform binary division (XOR operation)
        for (int i = 0; i < data.size(); i++) {
            if (paddedData[i] == '1') {
                for (int j = 0; j < divisor.size(); j++) {
                    // XOR with divisor
                    paddedData[i + j] = paddedData[i + j] == divisor[j] ? '0' : '1';
                }
            }
        }
        
        // The remainder is the last (degree of divisor) bits
        return paddedData.substr(data.size());
    }
    
    // Function to append CRC code to the data
    static string appendCRC(string data, string divisor) {
        // Get the CRC remainder
        string crc = crcCheck(data, divisor);
        // Append the CRC remainder to the original data
        return data + crc;
    }
    
    // Function to check the validity of the data (Receiver's side)
    static bool isValid(string data, string divisor) {
        string remainder = crcCheck(data, divisor);
        // If remainder is all zeros, the data is valid
        return remainder == string(divisor.size() - 1, '0');
    }
};

int main() {
    string data, divisor;
    
    // Input data and divisor (polynomial)
    cout << "Enter the data (binary): ";
    cin >> data;
    cout << "Enter the divisor (binary): ";
    cin >> divisor;
    
    // Append CRC to the data
    string dataWithCRC = CRC::appendCRC(data, divisor);
    cout << "Data with CRC appended: " << dataWithCRC << endl;
    
    // Validate the data (Receiver's side)
    if (CRC::isValid(dataWithCRC, divisor)) {
        cout << "Data is valid!" << endl;
    } else {
        cout << "Data is corrupted!" << endl;
    }
    
    return 0;
}